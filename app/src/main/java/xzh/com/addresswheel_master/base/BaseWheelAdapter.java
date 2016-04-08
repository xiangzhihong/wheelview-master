/*
 *  Copyright 2010 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package xzh.com.addresswheel_master.base;

import android.content.Context;


import java.util.List;

import xzh.com.addresswheel_master.view.wheelview.AbstractWheelTextAdapter;

public abstract class BaseWheelAdapter<T> extends AbstractWheelTextAdapter {

	/** The default items length */
	public static final int DEFAULT_LENGTH = -1;

	// items
	protected List<T> mList = null;

	/**
	 * Constructor
	 * @param list the items
	 * @param length the max items length
	 */
	public BaseWheelAdapter(Context context, List<T> list, int length) {
		super(context);
		this.mList = list;
	}

	/**
	 * Contructor
	 * @param list the items
	 */
	public BaseWheelAdapter(Context context, List<T> list) {
		this(context,list, DEFAULT_LENGTH);
	}

	public T getItemData(int index){
		if (index >= 0 && index < mList.size()) {
			return mList.get(index);
		}
		return null;
	}

	@Override
	public int getItemsCount() {
		return mList.size();
	}
}
