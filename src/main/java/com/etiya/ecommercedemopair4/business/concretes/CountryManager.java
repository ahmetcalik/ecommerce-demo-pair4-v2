package com.etiya.ecommercedemopair4.business.concretes;

import com.etiya.ecommercedemopair4.business.abstracts.CountrySevice;
import com.etiya.ecommercedemopair4.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercedemopair4.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercedemopair4.core.utilities.result.DataResult;
import com.etiya.ecommercedemopair4.entities.concretes.Country;
import com.etiya.ecommercedemopair4.repositories.abstracts.CountryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryManager implements CountrySevice {

    private CountryDao countryDao;

    @Override
    public List<ListCountryResponse> getAll() {
        return countryDao.getAll();
    }

    @Override
    public DataResult<AddCountryResponse> add(AddCountryRequest addCountryRequest) {

        Country country = new Country();
        country.setCountryName(addCountryRequest.getCountryName());

        countryDao.save(country);

        AddCountryResponse response = new AddCountryResponse(country.getId(), country.getCountryName());
        return new DataResult<AddCountryResponse>(response, true, "Ülke eklendi.");

    }

    @Override
    public CountryDetailResponse getById(int id) {
        return countryDao.getById(id);
    }
}
