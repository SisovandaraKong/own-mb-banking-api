package istad.co.darambbankingapi.init;

import istad.co.darambbankingapi.domain.CardType;
import istad.co.darambbankingapi.enums.CardTypeName;
import istad.co.darambbankingapi.features.cardType.CardTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CardTypeInit {
    private final CardTypeRepository cardTypeRepository;

    @PostConstruct
    void cardTypeData(){
        if(cardTypeRepository.count() < 1){
            CardType visa = new CardType();
            visa.setName(CardTypeName.VISA);
            visa.setIsDeleted(false);
            CardType masterCard = new CardType();
            masterCard.setName(CardTypeName.MASTERCARD);
            masterCard.setIsDeleted(false);
            cardTypeRepository.saveAll(List.of(visa, masterCard));
        }
    }
}
