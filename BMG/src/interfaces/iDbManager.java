package interfaces;

import database.BaseSetting;

public interface iDbManager 
{
    public boolean insert(BaseSetting bs);
    public boolean update(BaseSetting bs);
    public boolean delete(BaseSetting bs);
	
//    public Object findById(int id, BaseSetting bs);
//    public Object[] findAll(BaseSetting bs);
}
