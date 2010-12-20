<?php

$gwtphpmap = array(
	'extends' => 'com.imwebsoft.gwtphp.generator.beans.Master' ,
	'className' => 'com.imwebsoft.gwtphp.generator.beans.ATestClass' ,
	'mappedBy' => 'com.imwebsoft.gwtphp.generator.beans.ATestClass' ,	
	'typeCRC' => '${fileInfo.getTypeCRC()}'
,
	
'fields' => array (

array (
	'name' => 'id',
	'type' => TypeSignatures::$LONG
	)
,
array (
	'name' => 'myName',
	'type' => 'java.lang.String'
			,'typeCRC' => '${field.getTypeInfo().getCrc()}'
	)
,
array (
	'name' => 'myArray',
	'type' => '[Ljava.lang.String;'
			,'typeCRC' => 'null[Lnull;'
	)
,
array (
	'name' => 'myBool',
	'type' => 'java.lang.Boolean'
			,'typeCRC' => '${field.getTypeInfo().getCrc()}'
	)
,
array (
	'name' => 'aaaa',
	'type' => TypeSignatures::$INT
	)
,
array (
	'name' => 'aaaa22222',
	'type' => 'java.lang.String'
			,'typeCRC' => '${field.getTypeInfo().getCrc()}'
	)

					)
);
?>