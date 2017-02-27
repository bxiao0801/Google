class NestedInteger{
	Integer num;
	List<NestedInteger> list;
	boolean isInt;

	public NestedInteger(Integer i){
		num=i;
		isInt=true;
	}

	public NestedInteger(List<NestedInteger> l){
		list=l;
		isInt=false;
	}

	public boolean isInteger(){
		return isInt;
	}

	public Integer getInteger(){
		return num;
	}

	public List<NestedInteger> getList(){
		return list;
	}

	public static void main(String[] args){
		NestedInteger ni=new NestedInteger(Arrays.asList(new NestedInteger(1),
			new NestedInteger(Arrays.asList(new NestedInteger(4),new NestedInteger(Arrays.asList(new NestedInteger(6)))))));
		
		Iterator iter=new Iterator(ni);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}

class Iterator{
	Stack<NestedInteger> stack;
	public Iterator(NestedInteger n){
		stack=new Stack<>();
		stack.push(n);
		while(!stack.peek().isInteger()){
			List<NestedInteger> ni=stack.pop().getList();
			for(int i=ni.size()-1;i>=0;i--){
				stack.push(ni.get(i));
			}

		}
	}
	public boolean hasNext(){
		if(stack.empty()){
			return false;
		}

		while(!stack.peek().isInteger()){
			List<NestedInteger> ni=stack.pop().getList();
			for(int i=ni.size()-1;i>=0;i--){
				stack.push(ni.get(i));
			}
		}

		return true;
	}

	public Integer next(){
		return stack.pop().getInteger();
	}

}

