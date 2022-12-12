package mapper;

import class_.Brand;
import class_.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface tb_brandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);


//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);

//    List<Brand> selectByCondition(Brand brands);

    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Map map);

    void add(Brand brands);

    int updata(Brand brands);

    void del(int id);

//    void delids(int[] id);
    void delids(@Param("ids") int[] ids);
}
