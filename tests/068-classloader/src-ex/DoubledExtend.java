// Copyright 2008 Google Inc. All Rights Reserved.

/**
 * Doubled sub-class, form #2.
 */
public class DoubledExtend extends Base {
    public DoubledExtend() {
        System.out.println("Ctor: doubled extend, type 2");
    }

    @Override
    public DoubledExtend getExtended() {
        System.out.println("getExtended 2");
        return new DoubledExtend();
    }

    public String getStr() {
        return "DoubledExtend 2";
    }
}

