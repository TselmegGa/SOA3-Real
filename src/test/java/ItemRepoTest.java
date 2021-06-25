import domain.Item;
import domain.Project;
import infrastructure.ItemRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;

import static org.mockito.Mockito.when;

class ItemRepoTest {
    @Mock
    ItemRepository repo;
    @Test
    @ExtendWith(MockitoExtension.class)
    void getAllItemsFromRepo(){
        //arrange
        Project project = new Project();
        Item item = new Item(5, project, "Home Page");
        Item item2 = new Item(8, project, "Home Page");
        ArrayList<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        when(repo.getAll()).thenReturn(list);

        //act
        Iterable<Item> result = repo.getAll();

        //assert
        assertSame(result, list);
    }
    @Test
    @ExtendWith(MockitoExtension.class)
    void getItemFromRepo(){
        //arrange
        Project project = new Project();
        Item item = new Item(4, project, "Home Page");
        when(repo.get(1)).thenReturn(item);

        //act
        Item result = repo.get(1);

        //assert
        assertSame(result, item);
    }
    @Test
    @ExtendWith(MockitoExtension.class)
    void createItemWithRepo(){
        //arrange
        Project project = new Project();
        Item item = new Item(4, project, "Home Page");
        when(repo.add(item)).thenReturn(item);
        //act

        Item result = repo.add(item);
        //assert
        assertSame(result, item);
    }
    @Test
    @ExtendWith(MockitoExtension.class)
    void UpdateItemWithRepo(){
        //arrange
        Project project = new Project();
        Item item = new Item(4, project, "Home Page");
        when(repo.add(item)).thenReturn(item);
        //act

        Item result = repo.add(item);
        //assert
        assertSame(result, item);
    }
    @Test
    @ExtendWith(MockitoExtension.class)
    void DeleteItemWithRepo(){
        //arrange

        Project project = new Project();
        Item item = new Item(4, project, "Home Page");
        when(repo.add(item)).thenReturn(item);
        //act

        Item result = repo.add(item);
        repo.delete(item);
        Item result2 = repo.get(1);
        //assert
        assertSame(result, item);
        assertSame(result2, null);
    }
}
