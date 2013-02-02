/*
 * Copyright 2013 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.list;

import android.content.Context;
import android.widget.ListView;
import org.jetbrains.annotations.NotNull;
import org.solovyev.android.menu.ContextMenuBuilder;
import org.solovyev.android.menu.LabeledMenuItem;
import org.solovyev.android.menu.ListContextMenu;

import java.util.List;

/**
 * User: serso
 * Date: 5/5/12
 * Time: 7:52 PM
 */
public abstract class MenuOnClick<T> implements ListItem.OnClickAction {

    @NotNull
    private final List<? extends LabeledMenuItem<ListItemOnClickData<T>>> menuItems;

    protected MenuOnClick(@NotNull List<? extends LabeledMenuItem<ListItemOnClickData<T>>> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void onClick(@NotNull Context context, @NotNull ListAdapter<? extends ListItem> adapter, @NotNull ListView listView) {
        if (!menuItems.isEmpty()) {
            ContextMenuBuilder.newInstance(context, ListContextMenu.newInstance(menuItems)).create(new ListItemOnClickDataImpl<T>(getData(), adapter, listView)).show();
        }
    }

    @NotNull
    protected abstract T getData();
}
