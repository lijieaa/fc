package com.we.fc.dept;

import com.we.fc.dept.entity.Dept;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-01 15:21
 */

public class DeptUtils {

    public static List<Dept> getDeptLevelByParentId(Integer parentId, List<Dept> depts){
        List<Dept> result = new ArrayList<>();
        for(Dept dept : depts){
            if(dept.getParent().getId().equals(parentId))
                result.add(dept);
        }
        return result;
    }
}
