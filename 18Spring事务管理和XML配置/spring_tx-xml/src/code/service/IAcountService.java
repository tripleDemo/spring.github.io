package code.service;

public interface IAcountService {
	/**
	 * ��ָ���˻�ת��ָ��������һ���˻�
	 * @param outId
	 * @param inId
	 * @param money
	 */
	void trans(Long outId,Long inId,int money);
}
