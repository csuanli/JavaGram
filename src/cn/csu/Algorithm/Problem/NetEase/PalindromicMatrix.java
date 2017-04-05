package cn.csu.Algorithm.Problem.NetEase;

/**
 * 写一个函数打印如下矩阵：
 *    n=5			 n=6
 * 1 1 1 1 1    1 1 1 1 1 1
 * 1 2 3 2 1    1 2 3 3 2 1
 * 1 3 6 3 1    1 3 6 6 3 1
 * 1 2 3 2 1    1 3 6 6 3 1
 * 1 1 1 1 1    1 2 3 3 2 1
 *              1 1 1 1 1 1
 * 提示，除边上元素外，每个元素都是由边上某两个元素相加得到的。
 * @Li An
 */
public class PalindromicMatrix {

	public static void main(String[] args) {
		addMatrix(10);
	}
	
	public static void addMatrix(int n){
		int[][] matrix=new int[n][n];
		for(int i=0;i<(n+1)/2;i++){
			for(int j=0;j<(n+1)/2;j++){
				if(i==0){
					matrix[i][j]=1;
				}
				if(j==0){
					matrix[i][j]=1;
				}
				if(i>0&&j>0){
					matrix[i][j]=matrix[i][j-1]+matrix[i-1][j];
				}
				matrix[i][n-1-j]=matrix[i][j];	//左对称
				matrix[n-1-i][j]=matrix[i][j];	//下对称
				matrix[n-1-i][n-1-j]=matrix[i][j];	//左下对称
			}
		}
		print(matrix);
	}
	

	//打印二维数组
	public static void print(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
