package com.imwebsoft.gwtphp.generator.util;

import com.google.gwt.user.server.rpc.SerializationPolicy;

/**
 * @author Mile
 * 
 */
public class SignatureUtil {

	public static SerializationPolicy createSerializationPolicy() {
		return new SerializationPolicy() {
			@Override
			public boolean shouldDeserializeFields(final Class<?> clazz) {
				throw new UnsupportedOperationException(
						"shouldDeserializeFields");
			}

			@Override
			public boolean shouldSerializeFields(final Class<?> clazz) {
				return Object.class != clazz;
			}

			@Override
			public void validateDeserialize(final Class<?> clazz) {
				throw new UnsupportedOperationException("validateDeserialize");
			}

			@Override
			public void validateSerialize(final Class<?> clazz) {
			}
		};
	}

	public static String getSignature(String className) {
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// TODO : GWT 1.7
		return null; // SerializabilityUtil.getSerializationSignature(clazz);
		// TODO : GWT 2.1
		// return SerializabilityUtil.getSerializationSignature(clazz,
		// createSerializationPolicy() /* SerializationPolicy */);
	}
}
