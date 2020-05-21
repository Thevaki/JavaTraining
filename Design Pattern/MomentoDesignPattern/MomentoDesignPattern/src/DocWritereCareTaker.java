
//Creator
public class DocWritereCareTaker {
	private Object obj;

	public void save(DocWriter DocWriter) {
		this.obj = DocWriter.save();
	}

	public void undo(DocWriter DocWriter) {
		DocWriter.undoToLastSave(obj);
	}
}
