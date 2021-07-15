package com.dzq.study.web;
/**
 * 描述:
 * 包名:com.dzq.study.web
 * 版本信息: 版本1.0
 * 日期:2021/7/15
 * Copyright 三合力通
 */


import java.util.*;

/**
 * @describe：
 * @author: dengzq/三合力通
 * @version:v1.0
 * 2021/7/15 16:11
 */
public class JavaEventTest {

    public static void main(String[] args) {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener());
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");
        // 关门
        manager.fireWorkspaceClosed();
    }

}


//门事件对象
class DoorEvent extends EventObject {

    // 表示门的状态，有“开”和“关”两种
    private String doorState = "";

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source) {
        super(source);
    }

    public DoorEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }
}

// 事件监听器接口
interface BaseDoorListener extends EventListener {
    public void doorEvent(DoorEvent event);
}

//具体开关门动作事件
class DoorListener implements BaseDoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }
}

class DoorManager {
    private Collection listeners;

    /**
     * 添加事件
     *
     * @param listener
     *   DoorListener
     */
    public void addDoorListener(DoorListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     *
     * @param listener
     *   DoorListener
     */
    public void removeDoorListener(DoorListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        Iterator iter = listeners.iterator();
        while (iter.hasNext()) {
            DoorListener listener = (DoorListener) iter.next();
            listener.doorEvent(event);
        }
    }
}

