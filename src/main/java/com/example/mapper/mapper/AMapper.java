package com.example.mapper.mapper;

import com.example.mapper.model.A;
import com.example.mapper.model.ArrayA;
import com.example.mapper.model.B;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface AMapper {

    @IterableMapping(qualifiedByName = "mapFirstElementName")
    String mapName(A a);

    @IterableMapping(qualifiedByName = "mapFirstElementDescription")
    String mapDescription(A a);

    @Mapping(source = "listA", target = "someName", qualifiedByName = "mapFirstElementName")
    @Mapping(source = "listA", target = "someDescription", qualifiedByName = "mapFirstElementDescription")
    B mapFirstElement(ArrayA arrayA);

    @Named("mapFirstElementName")
    default String mapFirstElementName(ArrayList<A> listA) {
        if (listA != null && !listA.isEmpty()) {
            return mapName(listA.get(0));
        }
        return null;
    }

    @Named("mapFirstElementDescription")
    default String mapFirstElementDescription(ArrayList<A> listA) {
        if (listA != null && !listA.isEmpty()) {
            return mapDescription(listA.get(0));
        }
        return null;
    }
}