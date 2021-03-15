package org.cubit.customtable.api;

import org.cubit.customtable.customtable.CustomItem;

import java.util.List;

public interface ICustomTableManagerApi {

    // ?값만 가져와서 로드 CustomItem 를 반환 만약 ? 값이 없다면 null 반환
    CustomItem getLoadCustomItem(String name);

    // 전부값을 가져와서 CustomItem List 를 반환 만약 값이 없다면 null 반환

    List<CustomItem> getLoadCustomItems();






}
