package com.example.mapper.mapper;

import com.example.mapper.model.ArrayA;
import com.example.mapper.model.B;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AMapper {

    @Mapping(source = "listA", target = "someName", qualifiedByName = "mapFirstElementName")
    @Mapping(source = "listA", target = "someDescription", qualifiedByName = "mapFirstElementDescription")
    B mapFirstElement(ArrayA arrayA);

    @Named("mapFirstElementName")
    default String mapFirstElementName(ArrayA arrayA) {
        if (arrayA != null && arrayA.getListA() != null && !arrayA.getListA().isEmpty()) {
            return arrayA.getListA().get(0).getName();
        }
        return null;
    }

    @Named("mapFirstElementDescription")
    default String mapFirstElementDescription(ArrayA arrayA) {
        if (arrayA != null && arrayA.getListA() != null && !arrayA.getListA().isEmpty()) {
            return arrayA.getListA().get(0).getDescription();
        }
        return null;
    }
}
