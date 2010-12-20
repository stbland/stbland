package com.imwebsoft.gwtphp.generator.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imwebsoft.gwtphp.generator.bean.FieldInfo;
import com.imwebsoft.gwtphp.generator.bean.FileInfo;
import com.imwebsoft.gwtphp.generator.bean.MethodInfo;
import com.imwebsoft.gwtphp.generator.bean.TypeInfo;

/**
 * @author Mile
 * 
 */
public class FileTypeUtil {

	private static CharSequence beanString = "bean";
	private static CharSequence beansString = "beans";
	private static CharSequence serviceString = "Service";
	private static CharSequence asyncString = "Async";
	private static CharSequence demoString = "Demo";

	public static FileInfo getFileInfo(String superClass, String clazzName,
			String filePath) throws ClassNotFoundException {
		FileInfo fileInfo = new FileInfo();
		List<FieldInfo> fields = new ArrayList<FieldInfo>();
		List<MethodInfo> methods = new ArrayList<MethodInfo>();
		List<String> exceptions = new ArrayList<String>();
		String fileType;

		if (clazzName.contains(beansString) || clazzName.contains(beanString)) {
			fileType = "bean";
		} else if (clazzName.contains(serviceString)
				&& !clazzName.contains(asyncString)
				&& !clazzName.contains(demoString)) {
			fileType = "service";
		} else {
			return null;
		}
		Class cls = Class.forName(clazzName);

		Field fieldlist[] = cls.getDeclaredFields();
		for (int i = 0; i < fieldlist.length; i++) {
			Field fld = fieldlist[i];
			FieldInfo fieldInfo = new FieldInfo();
			fieldInfo.setName(fld.getName());

			TypeInfo typeInfo = null;
			String type = fld.getType().toString().replaceAll("class ", "");
			if (FileTypeUtil.getType(type) != null) {
				typeInfo = FileTypeUtil.getType(type);
			} else {
				typeInfo = new TypeInfo(type);
			}

			fieldInfo.setTypeInfo(typeInfo);
			fieldInfo.setNameUpper(StringUtil.getFirstLetterUp(fld.getName()));
			fields.add(fieldInfo);
		}
		Class clazz = cls;
		while (clazz.getSuperclass() != null) {
			if (clazz.getSuperclass() != null) {
				Field fieldlistSuper[] = clazz.getSuperclass()
						.getDeclaredFields();
				for (int i = 0; i < fieldlistSuper.length; i++) {
					Field fld = fieldlistSuper[i];
					FieldInfo fieldInfo = new FieldInfo();
					fieldInfo.setName(fld.getName());

					TypeInfo typeInfo = null;
					String type = fld.getType().toString().replaceAll("class ",
							"");
					if (FileTypeUtil.getType(type) != null) {
						typeInfo = FileTypeUtil.getType(type);
					} else {
						typeInfo = new TypeInfo(type);
					}

					fieldInfo.setTypeInfo(typeInfo);
					fieldInfo.setNameUpper(StringUtil.getFirstLetterUp(fld
							.getName()));
					fields.add(fieldInfo);
				}
			}
			clazz = clazz.getSuperclass();
		}

		Method methlist[] = cls.getDeclaredMethods();
		for (int i = 0; i < methlist.length; i++) {
			List<FieldInfo> params = new ArrayList<FieldInfo>();
			Method m = methlist[i];
			MethodInfo methodInfo = new MethodInfo();
			methodInfo.setName(m.getName());

			TypeInfo typeInfo = null;
			String type = m.getReturnType().toString().replaceAll("class ", "");
			if (FileTypeUtil.getType(type) != null) {
				typeInfo = FileTypeUtil.getType(type);
			} else {
				typeInfo = new TypeInfo(type);
			}

			methodInfo.setReturnType(typeInfo);
			Class pvec[] = m.getParameterTypes();
			for (int j = 0; j < pvec.length; j++) {
				typeInfo = null;
				type = pvec[j].toString().replaceAll("class ", "");
				if (FileTypeUtil.getType(type) != null) {
					typeInfo = FileTypeUtil.getType(type);
				} else {
					typeInfo = new TypeInfo(type);
				}
				params.add(new FieldInfo("a" + j, "", typeInfo));
			}

			Class evec[] = m.getExceptionTypes();
			for (int j = 0; j < evec.length; j++) {
				exceptions.add(evec[j].toString().replaceAll("class ", ""));
			}
			methodInfo.setParams(params);
			methods.add(methodInfo);
		}
		fileInfo = new FileInfo(cls.getPackage().toString().replaceAll(
				"package ", "").trim(), cls.getSimpleName(), filePath, fields,
				superClass, null, methods, exceptions, fileType);
		return fileInfo;
	}

	private static Map<String, TypeInfo> map;

	public static TypeInfo findType(String testType, List<String> imports)
			throws Exception {
		TypeInfo typeInfo = getType(testType);

		int array = 0;
		while (testType.endsWith("[]")) {
			array++;
			testType = testType.substring(0, testType.length() - 2);
			if (array > 1) {
				throw new Exception("Type: " + testType
						+ " is 2d or more array. Limit is 1D");
			}
		}

		// try within imports
		if (typeInfo == null) {
			CharSequence temp = testType;
			for (int i = 0; i < imports.size(); i++) {
				if (imports.get(i).contains(temp)) {
					typeInfo = handleIfArray(testType, imports.get(i), array);
					break;
				}
			}
		}
		return typeInfo;
	}

	private static TypeInfo handleIfArray(String type, String fullType,
			int array) {
		if (array > 0) {
			fullType = "[L" + fullType + ";";
		}
		return new TypeInfo(type, fullType);
	}

	public static TypeInfo getType(String type) {
		if (map == null) {
			map = new HashMap<String, TypeInfo>();
			map.put("void", new TypeInfo("TypeSignatures::$VOID"));
			map.put("int", new TypeInfo("TypeSignatures::$INT"));
			map.put("long", new TypeInfo("TypeSignatures::$LONG"));
			map.put("char", new TypeInfo("TypeSignatures::$CHAR"));
			map.put("boolean", new TypeInfo("TypeSignatures::$BOOLEAN"));
			map.put("byte", new TypeInfo("TypeSignatures::$BYTE"));
			map.put("float", new TypeInfo("TypeSignatures::$FLOAT"));
			map.put("double", new TypeInfo("TypeSignatures::$DOUBLE"));
			map.put("short", new TypeInfo("TypeSignatures::$SHORT"));
		}
		return map.get(type);
	}
}
