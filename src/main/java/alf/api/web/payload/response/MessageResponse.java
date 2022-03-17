package alf.api.web.payload.response;

public class MessageResponse {

	private String message = null;
	private int id = 0;
	private int status = 0;
	private Object entity = null;
	private Object list = null;

	public MessageResponse(String message) {
		this.message = message;
	}

	public MessageResponse(int id, int status, String message) {
		this.id = id;
		this.status = status;
		this.message = message;
	}

	public MessageResponse(int status, String message, Object entity) {
		this.status = status;
		this.message = message;
		this.entity = entity;
	}

	public MessageResponse(int status, String message, Object entity, Object list) {
		this.status = status;
		this.message = message;
		this.entity = entity;
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

}
