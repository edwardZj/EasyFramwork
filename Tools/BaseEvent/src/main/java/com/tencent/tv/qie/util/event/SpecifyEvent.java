package com.tencent.tv.qie.util.event;

class SpecifyEvent {
    String specify;
    Object obj;

    public SpecifyEvent(Object specify, Object obj) {
        this.specify = specify.getClass().getName() + "@" + specify.hashCode();
        this.obj = obj;
    }
}