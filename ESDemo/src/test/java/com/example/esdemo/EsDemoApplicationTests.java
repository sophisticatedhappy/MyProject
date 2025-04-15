package com.example.esdemo;

import com.alibaba.fastjson.JSON;
import com.example.esdemo.config.ElasticSearchConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
class EsDemoApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /*
    测试给es当中存储数据
     */
    @Test
    void contextLoads() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        //最常用的保存数据的方式
        User user = new User("hepan","male",24);
        String s = JSON.toJSONString(user);
        indexRequest.source(s, XContentType.JSON);

        //执行保存操作
        IndexResponse index = restHighLevelClient.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        //index是响应结果
        System.out.println(index); //获取响应结果
    }

    @Data
    @AllArgsConstructor
    public class User{
        public String userName;
        public String gender;
        public Integer age;

    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public class Account{
        private int accountNumber;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;

    }

    @Test
    public void test1() throws IOException{
        //1.创建检索请求
        SearchRequest searchRequest = new SearchRequest();
        // 指定索引
        searchRequest.indices("bank");
        //指定DSL，检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //1.1 构造条件检索
//        searchSourceBuilder.query();
//        searchSourceBuilder.from();
//        searchSourceBuilder.size();
//        searchSourceBuilder.aggregations();
        searchSourceBuilder.query(QueryBuilders.termQuery("address", "mill"));

        //1.2 按照年龄的值分布聚合
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        searchSourceBuilder.aggregation(ageAgg);

        //1.3 计算平均薪资
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        searchSourceBuilder.aggregation(balanceAvg);
        //打印检索条件
        System.out.println("检索条件:" + searchSourceBuilder.toString());

        searchRequest.source(searchSourceBuilder);


        //2.执行检索
        SearchResponse search = restHighLevelClient.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);

        //3.分析结果 search
        System.out.println(search.toString());
//        Map map = JSON.parseObject(search.toString(), Map.class);
        // 3.1 获取所有查到的数据
        SearchHits hits = search.getHits();
        SearchHit[] searchHits = hits.getHits();

        for (SearchHit hit : searchHits) {
            String sourceAsString = hit.getSourceAsString();
            Account account = JSON.parseObject(sourceAsString, Account.class);
            System.out.println(account);
        }

        //3.2 获取这次检索到的分析信息:
        Aggregations aggregations = search.getAggregations();
//        for (Aggregation aggregation : aggregations.asList()) {
//            System.out.println("聚合名称:"+ aggregation.getName());
//        }
        Terms ageAgg1 = aggregations.get("ageAgg");


    }

    @Test
    public void createIndex() throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("test_index");
        // 2、执行请求
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("createIndexResponse = " + createIndexResponse);
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @Test
    public void existIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("exists = " + exists);
    }

    /**
     * 测试删除索引
     */
    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("delete = " + delete);
    }

}
