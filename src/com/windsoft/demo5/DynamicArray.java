package com.windsoft.demo5;

/**
 * 动态数组
 */
public class DynamicArray {
    static final int MAX_SIZE = 2;
    private Object[] element;
    public int length;

    public DynamicArray() {
        element = new Object[MAX_SIZE];
        length = 0;
    }

    /**
     * 获取下标所对应的数组值
     * @param i 下标
     * @return 返回的类型
     */
    public Object get(int i){
        try {
            return element[i];
        }catch (ArrayIndexOutOfBoundsException event){
            event.printStackTrace();
            return event;
        }

    }

    /**
     * 向数组中添加元素
     * @param item 新元素
     */
    public void add(Object item){
        if (element.length > length){
            element[length] = item;
            length++;
        }else{
            Object[] copyElement = new Object[length + MAX_SIZE];
            for (int i = 0; i < length; i++){
                copyElement[i] = element[i];
            }
            element = copyElement;
            add(item);
        }
    }

    /**
     * 删除元素
     * @param i 删除元素的下标
     */
    public void remove(int i){
        for (int j = i+1; j < length; j++){
            element[j-1] = element[j];
        }
        if (length > 0){
            element[length-1] = null;
            length--;
        }

    }
}
