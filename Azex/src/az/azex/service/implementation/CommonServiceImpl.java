package az.azex.service.implementation;

import az.azex.domain.FlexibleList;
import az.azex.repository.CommonDao;
import az.azex.service.CommonService;

import java.util.List;
import java.util.Optional;

public class CommonServiceImpl implements CommonService {

    private CommonDao commonDao;

    public CommonServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<FlexibleList> getAllFlexibleList() {
        return commonDao.getAllFlexibleList();
    }

    @Override
    public Optional<FlexibleList> getFlexibleListById(long id) {
        return commonDao.getFlexibleListById(id);
    }

    @Override
    public Optional<FlexibleList> getFlexibleListByName(String name) {
        return commonDao.getFlexibleListByName(name);
    }
}
