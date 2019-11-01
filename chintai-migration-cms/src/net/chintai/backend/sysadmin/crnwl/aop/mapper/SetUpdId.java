package net.chintai.backend.sysadmin.crnwl.aop.mapper;

import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.batch.common.aop.mapper.support.SetUpd;

import org.aspectj.lang.annotation.Aspect;

/**
 * <pre>
 * SetUpdId
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-25 20:52:34 +0900 (水, 25 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2523 $
 * @since 1.0
 */
@Aspect
public class SetUpdId extends SetUpd {

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.batch.common.aop.mapper.SetUpdId#getSetValue()
	 */
	@Override
	protected Object getSetValue() {
		return IdHolder.getId();
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.batch.common.aop.mapper.support.SetValue#getFieldName()
	 */
	@Override
	protected String getFieldName() {
		return "updId";
	}

}
