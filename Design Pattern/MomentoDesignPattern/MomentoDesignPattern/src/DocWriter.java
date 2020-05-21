
//Originator
public class DocWriter{
	private String DocName;
	private StringBuilder content;

	public DocWriter(String Doc) {
		this.DocName = Doc;
		this.content = new StringBuilder();
	}

	@Override
	public String toString() {
		return this.content.toString();
	}

	public void write(String str) {
		content.append(str);
	}

	public Memento save() {
		return new Memento(this.DocName, this.content);
	}

	public void undoToLastSave(Object obj) {
		Memento memento = (Memento) obj;
		this.DocName = memento.DocName;
		this.content = memento.content;
	}

	//Momento
	private class Memento {
		private String DocName;
		private StringBuilder content;

		public Memento(String Doc, StringBuilder content) {
			this.DocName = Doc;
			this.content = new StringBuilder(content);
		}
	}
}
