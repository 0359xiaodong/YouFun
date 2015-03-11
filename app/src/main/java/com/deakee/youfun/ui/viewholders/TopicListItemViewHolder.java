package com.deakee.youfun.ui.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deakee.youfun.R;
import com.deakee.youfun.data.TopicListItem;

import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.util.CLog;
import in.srain.cube.views.list.ViewHolderBase;

/**
 * Created by Deekea on 2015/3/5.
 */
public class TopicListItemViewHolder extends ViewHolderBase<TopicListItem> {
    private final String TAG = "TopicListItemViewHolder";

    private ImageLoader mImageloader;

    private TextView mUserName;
    private ImageView mUserSex;
    private CubeImageView mUserHead;
    private TextView mPublishTime;
    private TextView mPayType;
    private TextView mSummary;
    private TextView mLocation;
    private CubeImageView mLocationImage;
    private TextView mLocationDistance;
    private View mTags;
    private TextView mVailTime;
    private TextView mJoinNum;
    private TextView mCommentNum;


    private TopicListItemViewHolder() {
        throw new RuntimeException("Call TopLevelViewHolder(ImageLoader imageLoader) instead.");
    }

    public TopicListItemViewHolder(ImageLoader imageLoader) {
        if (imageLoader != null) {
            mImageloader = imageLoader;
        } else {
            throw new NullPointerException("imageLoader is null");
        }
    }

    @Override
    public View createView(LayoutInflater layoutInflater) {
        CLog.d(TAG, "createView");

        View v = layoutInflater.inflate(R.layout.item_list_topic, null);
        mUserName = (TextView) v.findViewById(R.id.text_topic_user_name);
        mUserSex = (ImageView) v.findViewById(R.id.image_topic_user_sex);
        mUserHead = (CubeImageView) v.findViewById(R.id.image_topic_user_head);
        mPublishTime = (TextView) v.findViewById(R.id.text_topic_publish_time);
        mPayType = (TextView) v.findViewById(R.id.text_topic_pay_type);
        mSummary = (TextView) v.findViewById(R.id.text_topic_summary);
        mLocation = (TextView) v.findViewById(R.id.text_topic_location);
        mLocationImage = (CubeImageView) v.findViewById(R.id.image_topic_meal_location);
        mLocationDistance = (TextView) v.findViewById(R.id.text_topic_location_distance);
//        mTags
        mVailTime = (TextView) v.findViewById(R.id.text_topic_vail_time);
        mJoinNum = (TextView) v.findViewById(R.id.text_topic_join);
        mCommentNum = (TextView) v.findViewById(R.id.text_topic_comment);

        return v;
    }

    @Override
    public void showData(int position, TopicListItem itemData) {
        CLog.d(TAG, "position = " + position + " " + "itemData username = " + itemData.getUsername());
        mUserName.setText(itemData.getUsername());
        {
            int sexImageId;
            switch (itemData.getUserSexType()) {
                case TopicListItem.SEX_FEMALE:
                    sexImageId = R.drawable.icon_female;
                    break;
                case TopicListItem.SEX_MALE:
                    sexImageId = R.drawable.icon_male;
                    break;
                default:
                    sexImageId = 0;
                    break;
            }
            mUserSex.setBackgroundResource(sexImageId);
        }
        mUserHead.loadImage(mImageloader, itemData.getUserheadUrl());
        mPublishTime.setText(itemData.getPublishTime());
        {
            String payText;
            int bgId;
            switch (itemData.getPayType()) {
                case TopicListItem.PAY_TYPE_AA:
                    payText = "A A制";
                    bgId = R.drawable.selector_bg_item_topic_label_blue;
                    break;
                case TopicListItem.PAY_TYPE_ME:
                    payText = "我请客";
                    bgId = R.drawable.selector_bg_item_topic_label_green;
                    break;
                case TopicListItem.PAY_TYPE_YOU:
                    payText = "你请客";
                    bgId = R.drawable.selector_bg_item_topic_label_red;
                    break;
                default:
                    payText = "";
                    bgId = 0;
                    break;
            }
            mPayType.setText(payText);
            mPayType.setBackgroundResource(bgId);
        }
        mSummary.setText(itemData.getSummary());
        mLocation.setText(itemData.getLocation());
        mLocationImage.loadImage(mImageloader, itemData.getLocationImageUrl());
        mLocationDistance.setText(itemData.getLocationDistance());
//        mTags
        mVailTime.setText(itemData.getVailTime());
        mJoinNum.setText(itemData.getJoinNum());
        mCommentNum.setText(itemData.getCommentNum());

    }
}
