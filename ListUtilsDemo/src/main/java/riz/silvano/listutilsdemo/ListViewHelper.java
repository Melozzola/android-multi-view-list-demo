package riz.silvano.listutilsdemo;

import java.util.HashMap;
import java.util.Map;

import riz.silvano.listutils.RowHolder;
import riz.silvano.listutils.RowHolderFacade;
import riz.silvano.listutils.ViewTypes;
import riz.silvano.listutilsdemo.model.Actions;
import riz.silvano.listutilsdemo.model.Item;
import riz.silvano.listutilsdemo.model.Profile;
import riz.silvano.listutilsdemo.rowholder.ActionsRowHolder;
import riz.silvano.listutilsdemo.rowholder.ItemRowHolder;
import riz.silvano.listutilsdemo.rowholder.ProfileRowHolder;

/**
 * Implementation of {@link riz.silvano.listutils.ViewTypes} and {@link riz.silvano.listutils.RowHolderFacade}
 * <p/>
 * Created by mele on 08/09/2013.
 */
public final class ListViewHelper implements ViewTypes, RowHolderFacade
{

    // Static configuration
    private static Map<Class<?>, Integer> class2Type;
    private static Map<Integer, Integer> type2Res;
    private static Map<Integer, Class<?>> type2Class;

    static
    {
        class2Type = new HashMap<Class<?>, Integer>();
        type2Res = new HashMap<Integer, Integer>();
        type2Class = new HashMap<Integer, Class<?>>();

        class2Type.put(Profile.class, 0);
        class2Type.put(Actions.class, 1);
        class2Type.put(Item.class, 2);

        type2Res.put(0, R.layout.list_profile_row);
        type2Res.put(1, R.layout.list_actions_row);
        type2Res.put(2, R.layout.list_item_row);

        type2Class.put(0, Profile.class);
        type2Class.put(1, Actions.class);
        type2Class.put(2, Item.class);
    }

    @Override
    public int getRes(int type)
    {
        return type2Res.get(type);
    }

    @Override
    public int getCount()
    {
        return class2Type.size();
    }

    @Override
    public Class<?> getItemClass(int type)
    {
        return type2Class.get(type);
    }

    @Override
    public int getType(Class<?> clazz)
    {
        return class2Type.get(clazz);
    }

    @Override
    public RowHolder<?> newRowHolder(int i)
    {

        RowHolder<?> rh = null;

        switch (i)
        {
            case 0:
                rh = new ProfileRowHolder();
                break;
            case 1:
                rh = new ActionsRowHolder();
                break;
            case 2:
                rh = new ItemRowHolder();
                break;
        }
        return rh;
    }
}
