package cn.jiguang.imui.messages;

import android.support.v7.widget.CardView;
import android.view.View;

import cn.jiguang.imui.R;
import cn.jiguang.imui.commons.models.IMessage;

/**
 * 创建时间: 2019/1/20
 * gxx
 * 注释描述:xxxxx
 */
public class PostCarViewHolder <MESSAGE extends IMessage> extends BaseMessageViewHolder<MESSAGE>
        implements MsgListAdapter.DefaultMessageViewHolder {
    //public CardView cardView;
    public PostCarViewHolder(View itemView, boolean isSender) {
        super(itemView);
       // cardView =  itemView.findViewById(R.id.postcar_cardview);
    }

    @Override
    public void onBind(MESSAGE message) {

    }

    @Override
    public void applyStyle(MessageListStyle style) {

    }
}
