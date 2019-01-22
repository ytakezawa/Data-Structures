package lists;

public class NodeIntQuiz {
	// Data fields
    private Integer data;
    private NodeIntQuiz next;
	
    // Constructors
    NodeIntQuiz(Integer data) {
	this.data=data;
	this.next=null;
    }
    NodeIntQuiz(Integer data, NodeIntQuiz next) {
	this.data=data;
	this.next=next;
    }
	

    
    public boolean allEven() {
    	// Implement me!
    	boolean allE = true;
		NodeIntQuiz current = this;
		while (current != null) {
			if ((int)(current.data)%2 == 1) {	//item is odd and breaks the loop
				allE = false;
				break;
			}else {								//item is even and continues the loop
				allE = true ;
				current = current.next;
			}
		}
		return allE;
	    }
    
    
    public NodeIntQuiz stutter() {
    	//Implement me!
    	NodeIntQuiz current = this;
    	NodeIntQuiz result = new NodeIntQuiz(null);
    	NodeIntQuiz head = result;
    	while (current != null) {
    		result.next = new NodeIntQuiz (current.data);
    		result.next.next = new NodeIntQuiz(current.data);
    		result = result.next.next;
    		current = current.next;
    	}
    	return head.next;
	    }
    
    
    
    public String toString() {
		if (next==null) {
		    return data.toString();
		} else {
		    return data.toString() + "," + next.toString();
		}
    }
    
    public static void main(String[]  args) {
	NodeIntQuiz n1 = new NodeIntQuiz(1);
	NodeIntQuiz n2 = new NodeIntQuiz(2,n1);
	NodeIntQuiz n3 = new NodeIntQuiz(3,n2);
		
	System.out.println(n3.allEven());
	System.out.println(n3);
	System.out.println(n3.stutter());
    }
}
