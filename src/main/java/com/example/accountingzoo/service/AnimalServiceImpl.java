package com.example.accountingzoo.service;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalMapper;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import com.example.accountingzoo.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

}
