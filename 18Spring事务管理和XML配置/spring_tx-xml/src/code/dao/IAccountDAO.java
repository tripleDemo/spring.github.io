package code.dao;

public interface IAccountDAO {
	/**
	 * ��ָ���˻�ת������Ǯ
	 * @param outId
	 * @param money
	 */
	void transOut(Long outId,int money);
	
	/**
	 * ��ָ���˻�ת�����Ǯ
	 * @param outId
	 * @param money
	 */
	void transIn(Long inId,int money);
}
