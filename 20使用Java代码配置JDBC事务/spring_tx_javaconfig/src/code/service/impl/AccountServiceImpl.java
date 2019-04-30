package code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import code.dao.IAccountDAO;
import code.service.IAcountService;

@Service
@Transactional
public class AccountServiceImpl implements IAcountService {
	@Autowired
	private IAccountDAO dao;
	
	public void trans(Long outId, Long inId, int money) {
		dao.transOut(outId, money);
		int a = 1 / 0;//抛出一个算术异常(模拟程序有异常)
		dao.transIn(inId, money);
	}

	@Transactional(readOnly = true)
	public void listXxx() {
		
	}
}
