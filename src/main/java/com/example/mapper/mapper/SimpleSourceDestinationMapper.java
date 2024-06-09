package com.example.mapper.mapper;

import com.example.mapper.model.A;
import com.example.mapper.model.B;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {


    @Mapping(source = "name", target = "someName")
    @Mapping(source = "description", target = "someDescription")
    B aToB(A entity);
}
