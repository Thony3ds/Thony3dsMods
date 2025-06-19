package com.thony3ds.criterions;

import com.thony3ds.Thony3dsMods;
import net.minecraft.advancement.criterion.Criteria;

public class Thony3dsModsCriteria {
    public static final Thony3dsModsOnJoinCriterion JOIN_GAME = Criteria.register(Thony3dsMods.MOD_ID + ":join_game", new Thony3dsModsOnJoinCriterion());
    public static final  Thony3dsModsCategoryCompleteCriterion CATEGORY_COMPLETE = Criteria.register(Thony3dsMods.MOD_ID+":categorie_complete", new Thony3dsModsCategoryCompleteCriterion());

    public static void initialize(){}
}
