package code.service.impl;

import code.dao.IAccountDAO;
import code.service.IAcountService;

public class AccountServiceImpl implements IAcountService {
	private IAccountDAO dao;
	
	public void setDao(IAccountDAO dao) {
		this.dao = dao;
	}
	
	public void trans(Long outId, Long inId, int money) {
		dao.transOut(outId, money);
		int a = 1 / 0;//�׳�һ�������쳣(ģ��������쳣)
		dao.transIn(inId, money);
	}

}
