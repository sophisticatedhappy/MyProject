package com.example.mybatisdemo.demos.web.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.example.mybatisdemo.demos.web.Enum.DeleteEnum;

public class DeleteConverter implements Converter<Integer> {


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) throws Exception {
        return new WriteCellData<>(DeleteEnum.convert(context.getValue()).getDescription());
    }
}
