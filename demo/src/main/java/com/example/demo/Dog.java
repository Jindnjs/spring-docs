package com.example.demo;

public class Dog {

    private Dog field;

    private Dog() {
    }

    public static Dog getInstance() {
        if(field == null) {
            field = new Dog();
        }
        return field;
    }
}

class A{
    public static void main(String[] args) {

        Dog dog = Dog.getInstance();

        Dog dog2 = Dog.getInstance();

        Dog dog3 = Dog.getInstance();
    }
}



부모님과 자식이있어

        집안에서 보물을 하나 관리하기러 했어

보물 주머니가 필요하겠지??


손님이 처음오면  >보물을 만들고 보여줘야하고

손님이 두번쨰부터는 > 만들어놓은 보물을 보여주기만하면되는거야


static이라는거는 보물주머니를 우리 가족이 관리하는거야