package xzh.com.addresswheel_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xzh.com.addresswheel_master.model.AddressDtailsEntity;
import xzh.com.addresswheel_master.model.AddressModel;
import xzh.com.addresswheel_master.utils.JsonUtil;
import xzh.com.addresswheel_master.utils.Utils;
import xzh.com.addresswheel_master.view.ChooseAddressWheel;
import xzh.com.addresswheel_master.view.listener.OnAddressChangeListener;

public class MainActivity extends AppCompatActivity implements OnAddressChangeListener {

    @Bind(R.id.choose_address)
    TextView chooseAddress;

    private ChooseAddressWheel chooseAddressWheel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initWheel();
        initData();
    }

    private void initWheel() {
        chooseAddressWheel = new ChooseAddressWheel(this);
        chooseAddressWheel.setOnAddressChangeListener(this);
    }

    private void initData() {
        String address = Utils.readAssert(this, "address.txt");
        AddressModel model = JsonUtil.parseJson(address, AddressModel.class);
        if (model != null) {
            AddressDtailsEntity data = model.Result;
            if (data == null) return;
            chooseAddress.setText(data.Province + " " + data.City + " " + data.Area);
            if (data.ProvinceItems != null && data.ProvinceItems.Province != null) {
                chooseAddressWheel.setProvince(data.ProvinceItems.Province);
                chooseAddressWheel.defaultValue(data.Province, data.City, data.Area);
            }
        }
    }

    @OnClick(R.id.choose_address)
    public void addressClick(View view) {
        Utils.hideKeyBoard(this);
        chooseAddressWheel.show(view);
    }

    @Override
    public void onAddressChange(String province, String city, String district) {
        chooseAddress.setText(province + " " + city + " " + district);
    }
}
