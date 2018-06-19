package model;
/**
 * 
 * @author lygwangyp
 * @category “读者信息表”
 */


public class Reader {
	private String idReader;
	private String nameReader;
	private String type;
	private String sex;
	private String password;
	public String getIdReader() {
		return idReader;
	}
	public void setIdReader(String idReader) {
		this.idReader = idReader;
	}
	public String getNameReader() {
		return nameReader;
	}
	public void setNameReader(String nameReader) {
		this.nameReader = nameReader;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReader == null) ? 0 : idReader.hashCode());
		result = prime * result + ((nameReader == null) ? 0 : nameReader.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (idReader == null) {
			if (other.idReader != null)
				return false;
		} else if (!idReader.equals(other.idReader))
			return false;
		if (nameReader == null) {
			if (other.nameReader != null)
				return false;
		} else if (!nameReader.equals(other.nameReader))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String toString() {
		return "Reader [idReader=" + idReader + ", nameReader=" + nameReader + ", type=" + type + ", sex=" + sex
				+ ", password=" + password + "]";
	}

}
