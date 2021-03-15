package org.cubit.customtable.api;

import org.cubit.customtable.customtable.CustomItem;
import org.cubit.customtable.customtable.CustomItemPlayer;

public interface ITimeConnectorApi {

    //제작시간 타이머

    void startTime(CustomItem customItem);

    void stopTime(CustomItem customItem);
}
