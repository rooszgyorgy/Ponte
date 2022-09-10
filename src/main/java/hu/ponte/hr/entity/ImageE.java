package hu.ponte.hr.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "image")
public class ImageE {
	
	@Id
	private String id;
	private String name;
	private String mimeType;
	private long size;
	private String digitalSign;
	
	public ImageE()
	{
		
	}
	
	/*
	 * Szebb lenne, ha a repositoryn keresztül töltődne :)
	 */
	public ImageE( String id, String name, String mimeType, long size, String digitalSign ) {
		
		this.id = id;
		this.name = name;
		this.mimeType = mimeType;
		this.size = size;
		this.digitalSign = digitalSign;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getDigitalSign() {
		return digitalSign;
	}

	public void setDigitalSign(String digitalSign) {
		this.digitalSign = digitalSign;
	}

	@Override
	public String toString() {
		return "ImageE [id=" + id + ", name=" + name + ", mimeType=" + mimeType + ", size=" + size + ", digitalSign="
				+ digitalSign + "]";
	}
	
	
	
}
