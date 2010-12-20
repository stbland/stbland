<?php
$gwtphpmap = array (	
	array( 
		'className' => 'com.imwebsoft.gwtphp.generator.Service' ,
		'mappedBy' => 'com.imwebsoft.gwtphp.generator.Service' ,
		'methods' => array (
		array(
			'name' => 'sayHi',
			'mappedName'=>'sayHi',
			'returnType' =>  'java.lang.String',
		    'returnTypeCRC' => '${method.getReturnType().getCrc()}',
			'params' => array( 
										array(
				'type'=>'java.lang.String'
		,  'typeCRC' => '${param.getTypeInfo().getCrc()}'
				) 
														) ,
			'throws' => array()
			
		) 
	)	
	)
);

?>