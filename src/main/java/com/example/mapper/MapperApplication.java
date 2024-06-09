package com.example.mapper;

import com.example.mapper.mapper.AMapper;
import com.example.mapper.mapper.SimpleSourceDestinationMapper;
import com.example.mapper.model.A;
import com.example.mapper.model.ArrayA;
import com.example.mapper.model.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MapperApplication {

    private static SimpleSourceDestinationMapper mapper;
    private static AMapper aMapper;

    public MapperApplication(SimpleSourceDestinationMapper mapper, AMapper aMapper) {
        this.mapper = mapper;
        this.aMapper = aMapper;

    }

    public static void main(String[] args) {
        SpringApplication.run(MapperApplication.class, args);

        A a = new A("Example Name", "Example Description");
        B b = mapper.aToB(a);
//        System.err.println(b.getSomeName() + ", " + b.getSomeDescription());

        A a1 = new A("first", "second");
        A a2 = new A("three", "four");
        ArrayList<A> arrayListZ = new ArrayList<>();
        arrayListZ.add(a1);
        arrayListZ.add(a2);

        ArrayA arrayA = new ArrayA();
        arrayA.setListA(arrayListZ);

//        ArrayA1{listA=[A{name='first', description='second'}, A{name='three', description='four'}]}


        B b1 = aMapper.mapFirstElement(arrayA);

        System.err.println(b1.getSomeName() + ", " + b.getSomeDescription());



    }

}
