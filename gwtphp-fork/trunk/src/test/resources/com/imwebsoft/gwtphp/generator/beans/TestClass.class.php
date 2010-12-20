<?php

class TestClass implements GWTPHPSerializable  {
	
	private $id;
	private $myName;
	private $myArray;
	private $myBool;
	private $aaaa;
	private $aaaa22222;

	public function setId($id) {
		$this->id = $id;
	}
	public function setMyName($myName) {
		$this->myName = $myName;
	}
	public function setMyArray($myArray) {
		$this->myArray = $myArray;
	}
	public function setMyBool($myBool) {
		$this->myBool = $myBool;
	}
	public function setAaaa($aaaa) {
		$this->aaaa = $aaaa;
	}
	public function setAaaa22222($aaaa22222) {
		$this->aaaa22222 = $aaaa22222;
	}

	public function getId() {
		return $this->id;
	}
	public function getMyName() {
		return $this->myName;
	}
	public function getMyArray() {
		return $this->myArray;
	}
	public function getMyBool() {
		return $this->myBool;
	}
	public function getAaaa() {
		return $this->aaaa;
	}
	public function getAaaa22222() {
		return $this->aaaa22222;
	}

}

?>