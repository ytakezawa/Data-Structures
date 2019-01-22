package lists;

public class NodeInt {
	//data fields
	private Integer data;
	private NodeInt next;
	
	//constructor
	NodeInt(Integer i){
		data = i;
		next = null;
	}
	NodeInt (Integer i, NodeInt next){
		data = i;
		this.next = next;
	}
	
	public Integer sum() {
		if(next == null) {//end of the list
			return data;
		}else {//tail is not empty
			return data + next.sum();
		}
	}
	
	public Integer sum2() {
		Integer sum = 0;
		NodeInt current = this;
		
		while (current != null) {
			sum = sum + current.data;
			current = current.next;
		}
		return sum;
	}
	
	public boolean allPositive() {
		//checks if all are positive
		if(next == null) {//end of the list
			return (data> 0);
		}else {//tail is not empty
			return (data >=0) && next.allPositive();
		}
	}
	
	public boolean allPositive2() {
		//checks if all are positive
		boolean allp = true;
		NodeInt current = this;
		
		while (current != null) {
			allp = allp &&(current.data >=0);
			current = current.next;
		}
		
		return allp;
	}
	
	public NodeInt bump() {
		// bumps all elements up one
		if (next == null) { //this has no tail
			return new NodeInt(data +1);
		}else {// this has a tail
			return new NodeInt(data + 1, next.bump());
		}
	}
	
	public NodeInt bump2() {
		NodeInt result = new NodeInt (null);
		NodeInt head = result;
		NodeInt current = this;
		
		while(current !=null) {
			result.next = new NodeInt(data+1);
			result = result.next;
			current = current.next;
		}
		
		return head.next;
	}
	
	public Integer size() {
		int funsize = 0;
		NodeInt current = this;
		while (current != null) {
			funsize ++;
			current= current.next;
		}
		return funsize;
	}
	
	public String toString() {
		NodeInt current = this;
		StringBuilder str = new StringBuilder();
		str.append("new list is ");
		while ( current != null) {
			str.append(current.data.toString());
			str.append(" ");
			current = current.next;
		}
		return str.toString();
	}
	
	public static void main (String []args) {
		NodeInt n1 = new NodeInt(3); //first construct
		NodeInt n2 = new NodeInt(2, n1); // second construct
		NodeInt n3 = new NodeInt(1, n2);
		
		System.out.println(n3.sum());
		System.out.println(n3.bump());
		System.out.println(n3.size());
	}
}
