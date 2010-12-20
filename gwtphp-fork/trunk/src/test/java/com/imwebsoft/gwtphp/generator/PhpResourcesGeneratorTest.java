package com.imwebsoft.gwtphp.generator;

import java.io.File;

import junit.framework.TestCase;

/**
 * @author Milan Dinic
 * 
 */
public class PhpResourcesGeneratorTest extends TestCase {

	public void testGenerate() throws Exception {

		File srcFile = new File(
				"./src/test/java/com/imwebsoft/gwtphp/generator/");
		@SuppressWarnings("unused")
		Generator generator = new Generator(srcFile, "./src/test/resources/");
	}

}
