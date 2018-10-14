package com.graphics;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c_liuguangming on 2017/1/17.
 */
public class ImageTable {
	private String title;
    private Cell[] headCells;
    private Cell[][] cells;
	private int imageHeight;
	private int imageWidth;
	private int top; // 顶部空白
	private int bottom;// 底部空白
	private int left;// 左边空白
	private int right;// 右边空白
	private int[] rowHeightArray;// 表格（划线）每行高度
	private int[] columnWidthArray;// 表格（划线）每列宽度
	private String bgImage;// 背景图片

	public ImageTable(Builder builder) {
		this.imageHeight = builder.imageHeight;
		this.imageWidth = builder.imageWidth;
		this.top = builder.top;
		this.bottom = builder.bottom;
		this.left = builder.left;
		this.right = builder.right;
		this.rowHeightArray = builder.rowHeightArray;
		this.columnWidthArray = builder.columnWidthArray;
		this.bgImage = builder.bgImage;
        this.title = builder.title;
        this.headCells = builder.headCells;
        this.cells = builder.cells;
	}

	public void init() {
		Assert.notNull(rowHeightArray);
		Assert.notNull(columnWidthArray);
		initArray(rowHeightArray, top, bottom, imageHeight);
		initArray(columnWidthArray, left, right, imageWidth);
	}

	private void initArray(int[] rowOrColumnArray, int topOrleft,
			int bottomOrRight, int imageHeightOrWidth) {
		int totalLen = 0;
		int zeroCount = 0;
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < rowOrColumnArray.length; i++) {
			int len = rowOrColumnArray[i];
			if (len <= 0) {
				indexList.add(i);
				zeroCount++;
			} else {
				totalLen = totalLen + len;
			}
		}
		if (zeroCount > 0) {
			int difference = imageHeightOrWidth - topOrleft - bottomOrRight
					- totalLen;
			int avg = difference / zeroCount;
			int remainder = difference % zeroCount;
			for (Integer index : indexList) {
				rowOrColumnArray[index] = avg;
			}
			int lastZeroIndex = indexList.get(indexList.size() - 1);
			rowOrColumnArray[lastZeroIndex] = avg + remainder;
		}
	}

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[] getHeadCells() {
        return headCells;
    }

    public void setHeadCells(Cell... headCells) {
        this.headCells = headCells;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public void setColumnWidthArray(int[] columnWidthArray) {
		this.columnWidthArray = columnWidthArray;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int[] getRowHeightArray() {
		return rowHeightArray;
	}

	public void setRowHeightArray(int... rowHeightArray) {
		this.rowHeightArray = rowHeightArray;
	}

	public int[] getColumnWidthArray() {
		return columnWidthArray;
	}

	public void setcolumnWidthArray(int... columnWidthArray) {
		this.columnWidthArray = columnWidthArray;
	}

	public static class Builder {
        private String title;
        private Cell[] headCells;
        private Cell[][] cells;
		private int imageHeight;
		private int imageWidth;
		private int top; // 顶部空白
		private int bottom;// 底部空白
		private int left;// 左边空白
		private int right;// 右边空白
		private int[] rowHeightArray;// 表格（划线）每行高度
		private int[] columnWidthArray;// 表格（划线）每列宽度
		private String bgImage;


		public Builder() {
		}

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder headCells(Cell[] headCells) {
            this.headCells = headCells;
            return this;
        }
        public Builder cells(Cell[][] cells) {
            this.cells = cells;
            return this;
        }
		public Builder bgImage(String bgImage) {
			this.bgImage = bgImage;
			return this;
		}

		public Builder imageHeight(int imageHeight) {
			this.imageHeight = imageHeight;
			return this;
		}

		public Builder imageWidth(int imageWidth) {
			this.imageWidth = imageWidth;
			return this;
		}

		public Builder top(int top) {
			this.top = top;
			return this;
		}

		public Builder bottom(int bottom) {
			this.bottom = bottom;
			return this;
		}

		public Builder left(int left) {
			this.left = left;
			return this;
		}

		public Builder right(int right) {
			this.right = right;
			return this;
		}

		public Builder rowHeightArray(int... rowHeightArray) {
			this.rowHeightArray = rowHeightArray;
			return this;
		}

		public Builder columnWidthArray(int... columnWidthArray) {
			this.columnWidthArray = columnWidthArray;
			return this;
		}

		public ImageTable build() {
			ImageTable imageTable = new ImageTable(this);
			imageTable.init();
			return imageTable;
		}
	}
}
