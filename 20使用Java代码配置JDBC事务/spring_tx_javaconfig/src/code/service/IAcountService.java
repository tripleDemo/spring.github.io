package code.service;

public interface IAcountService {
	/**
	 * 从指定账户转出指定金额给另一个账户
	 * @param outId
	 * @param inId
	 * @param money
	 */
	void trans(Long outId,Long inId,int money);
}
