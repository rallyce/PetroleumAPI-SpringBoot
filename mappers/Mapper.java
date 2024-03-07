package com.rallyce.Petroleum_Inventario.mappers;

public interface Mapper<A,B> {

    B mapto(A a);

    A mapFrom(B b);

}
