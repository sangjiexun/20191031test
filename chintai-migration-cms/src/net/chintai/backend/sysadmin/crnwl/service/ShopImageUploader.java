package net.chintai.backend.sysadmin.crnwl.service;

import java.io.IOException;
import java.nio.file.Path;

import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.gazohaisin.upload.shop.Uploader;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;

/**
 * <pre>
 * ShopImageUploader
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-25 20:52:34 +0900 (水, 25 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2523 $
 * @since 1.0
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShopImageUploader extends Uploader {

	private final String updPg;

	private final String id;

	/**
	 * @param s3
	 * @param s3Bucket
	 * @param image
	 * @param updPg
	 * @param id
	 */
	public ShopImageUploader(final AmazonS3 s3, final String s3Bucket, final Path image, final String updPg,
			final String id) {
		super(s3, s3Bucket, image);
		this.updPg = updPg;
		this.id = id;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.batch.gazohaisin.upload.shop.Uploader#callInternal()
	 */
	@Override
	protected Boolean callInternal() throws IOException {
		PgHolder.setPg(this.updPg);
		IdHolder.setId(this.id);
		return super.callInternal();
	}

}
