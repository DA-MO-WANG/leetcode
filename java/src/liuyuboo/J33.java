package liuyuboo;

public class J33 {
    public boolean verifyPostorder(int[] postorder) {
       return verifyPostorder(postorder,0,postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int left1, int right2) {
        int root = postorder[right2];
        int i = left1;
        for (; i < right2; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for (;j < right2; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }

        //
        boolean left = true;
        if (i > 0) {
            left = verifyPostorder(postorder,left1,i - 1);
        }
        boolean right = true;
        for (;i < postorder.length - 1; i++) {
            right = verifyPostorder(postorder,i,right2 - 1);
        }
        return left && right;
    }


}
