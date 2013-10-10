package riz.silvano.listutilsdemo;

import java.util.HashMap;
import java.util.Map;

import riz.silvano.listutils.RowHolder;
import riz.silvano.listutils.RowHolderFacade;
import riz.silvano.listutils.ViewTypes;
import riz.silvano.listutilsdemo.model.Header;
import riz.silvano.listutilsdemo.model.OneValue;
import riz.silvano.listutilsdemo.model.ThreeValues;
import riz.silvano.listutilsdemo.model.TwoValues;
import riz.silvano.listutilsdemo.rowholder.HeaderRowHolder;
import riz.silvano.listutilsdemo.rowholder.OneLineRowHolder;
import riz.silvano.listutilsdemo.rowholder.ThreeLinesRowHolder;
import riz.silvano.listutilsdemo.rowholder.TwoLinesRowHolder;

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

        class2Type.put(Header.class, 0);
        class2Type.put(OneValue.class, 1);
        class2Type.put(TwoValues.class, 2);
        class2Type.put(ThreeValues.class, 3);

        type2Res.put(0, R.layout.item_header);
        type2Res.put(1, R.layout.item_one_line);
        type2Res.put(2, R.layout.item_two_lines);
        type2Res.put(3, R.layout.item_three_lines);

        type2Class.put(0, Header.class);
        type2Class.put(1, OneValue.class);
        type2Class.put(2, TwoValues.class);
        type2Class.put(3, ThreeValues.class);
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
                rh = new HeaderRowHolder();
                break;
            case 1:
                rh = new OneLineRowHolder();
                break;
            case 2:
                rh = new TwoLinesRowHolder();
                break;
            case 3:
                rh = new ThreeLinesRowHolder();
                break;
        }
        return rh;
    }
}
